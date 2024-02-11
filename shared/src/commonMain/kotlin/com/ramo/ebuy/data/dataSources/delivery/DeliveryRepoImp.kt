package com.ramo.ebuy.data.dataSources.delivery

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_DELIVERY_PROCESS
import io.github.jan.supabase.SupabaseClient

class DeliveryRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), DeliveryRepo {

    override suspend fun getDeliveryOnId(id: Long): DeliveryProcess? {
        return querySingle(SUPA_DELIVERY_PROCESS) {
            DeliveryProcess::productId eq id
        }
    }

    override suspend fun addNewDelivery(item: DeliveryProcess): DeliveryProcess? {
        return insert(SUPA_DELIVERY_PROCESS, item)
    }

    override suspend fun editDelivery(item: DeliveryProcess): DeliveryProcess? {
        return edit(SUPA_DELIVERY_PROCESS, item.id, item)
    }

    override suspend fun deleteDelivery(id: Long): Int {
        return delete(SUPA_DELIVERY_PROCESS, id)
    }
}