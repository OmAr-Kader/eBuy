package com.ramo.ebuy.data.util

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.PostgrestFilterDSL
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.postgrest.query.filter.FilterOperator
import io.github.jan.supabase.postgrest.query.filter.PostgrestFilterBuilder

abstract class BaseRepoImp(val supabase: SupabaseClient) {

    suspend inline fun <reified T : BaseObject> insert(
        table: String,
        item: T,
    ): T? {
        return supabase {
            supabase.from(table).insert(item.json()) {
                select()
            }.decodeList<T>().firstOrNull()
        }
    }

    suspend inline fun <reified T : BaseObject> insertList(
        table: String,
        items: List<T>,
    ): List<T>? {
        return supabase {
            supabase.from(table).insert(items.map { it.json() }) {
                select()
            }.decodeList<T>()
        }
    }

    suspend inline fun <reified T : BaseObject> edit(
        table: String,
        id: Long,
        edit: T
    ): T? {
        return supabase {
            supabase.from(table).update(edit.json()) {
                select()
                filter {
                    eq("id", id)
                }
            }.decodeList<T>().firstOrNull()
        }
    }

    suspend inline fun delete(table: String, id: Long): Int {
        return supabase {
            supabase.from(table).delete {
                select()
                filter {
                    filter("id", FilterOperator.EQ, id)
                }
            }
        }.let {
            if (it != null) 1 else -1
        }
    }

    suspend inline fun <reified T : BaseObject> querySingle(
        table: String,
        crossinline block: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
    ): T? {
        return supabase {
            supabase.from(table).select {
                filter(block)
            }.decodeList<T>().firstOrNull()
        }
    }

    suspend inline fun <reified T : BaseObject> query(
        table: String,
        crossinline block: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
    ): List<T> {
        return supabase {
            supabase.from(table).select {
                order("id", Order.ASCENDING)
                filter(block)
            }.decodeList<T>()
        } ?: emptyList()
    }

    suspend inline fun <reified T : BaseObject> queryAll(
        table: String,
    ): List<T> {
        return supabase {
            supabase.from(table).select{
                order("id", Order.ASCENDING)
            }.decodeList<T>()
        } ?: emptyList()
    }
}