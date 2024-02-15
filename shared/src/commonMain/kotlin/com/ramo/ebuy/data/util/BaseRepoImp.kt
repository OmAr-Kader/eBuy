package com.ramo.ebuy.data.util

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.PostgrestFilterDSL
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.postgrest.query.PostgrestRequestBuilder
import io.github.jan.supabase.postgrest.query.filter.FilterOperator
import io.github.jan.supabase.postgrest.query.filter.PostgrestFilterBuilder

abstract class BaseRepoImp(val supabase: SupabaseClient) {

    suspend inline fun <reified T : BaseObject> insert(
        table: String,
        item: T,
    ): T? {
        return supabase {
            supabase.from(table).insert(item) {
                select()
            }.decodeList<T>().firstOrNull()
        }
    }

    suspend inline fun <reified T : BaseObject> upsert(
        table: String,
        onConflict: String,
        item: T,
    ): T? {
        return supabase {
            supabase.from(table).upsert(item, onConflict = onConflict) {
                select()
            }.decodeList<T>().firstOrNull()
        }
    }

    suspend inline fun <reified T : BaseObject> edit(
        table: String,
        id: Long,
        edit: T
    ): T? {
        return supabase {
            supabase.from(table).update(edit) {
                filter {
                    eq("id", id)
                }
                select()
            }.decodeList<T>().firstOrNull()
            edit
        }
    }

    suspend inline fun delete(table: String, id: Long): Int {
        return supabase {
            supabase.from(table).delete {
                filter {
                    filter("id", FilterOperator.EQ, id)
                }
            }
        }.let {
            if (it != null) 1 else -1
        }
    }

    suspend inline fun deleteFilter(table: String, crossinline block: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit): Int {
        return supabase {
            supabase.from(table).delete {
                filter(block)
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
                order("id", Order.DESCENDING)
                filter(block)
            }.decodeList<T>()
        } ?: listOf()
    }

    suspend inline fun <reified T : BaseObject> queryAllOrder(
        table: String,
        crossinline block: @PostgrestFilterDSL PostgrestRequestBuilder.() -> Unit,
    ): List<T> {
        return supabase {
            supabase.from(table).select(request = block).decodeList<T>()
        } ?: listOf()
    }

    suspend inline fun querySingleByForeign(
        table: String,
        columns: Columns,
        crossinline block: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
    ): io.github.jan.supabase.postgrest.result.PostgrestResult? {
        return supabase {
            supabase.from(table).select(
                columns = columns
            ) {
                filter(block)
            }
        }
    }

    suspend inline fun <reified T : BaseObject> queryByForeign(
        table: String,
        columns: Columns,
        crossinline block: @PostgrestFilterDSL PostgrestFilterBuilder.() -> Unit,
    ): List<T> {
        return supabase {
            supabase.from(table).select(
                columns = columns
            ) {
                order("id", Order.DESCENDING)
                filter(block)
            }.toListOfObject<T>()
        } ?: listOf()
    }

    suspend inline fun <reified T : BaseObject> queryAll(
        table: String,
    ): List<T> {
        return supabase {
            supabase.from(table).select {
                order("id", Order.DESCENDING)
            }.decodeList<T>()
        } ?: listOf()
    }
}