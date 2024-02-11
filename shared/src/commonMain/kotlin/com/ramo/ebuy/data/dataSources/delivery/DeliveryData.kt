package com.ramo.ebuy.data.dataSources.delivery

import com.ramo.ebuy.data.model.DeliveryProcess

class DeliveryData(
    private val repo: DeliveryRepo
) {
    suspend fun getDeliveryOnId(id: Long): DeliveryProcess? = repo.getDeliveryOnId(id)
    suspend fun addNewDelivery(item: DeliveryProcess): DeliveryProcess? = repo.addNewDelivery(item)
    suspend fun editDelivery(item: DeliveryProcess): DeliveryProcess? = repo.editDelivery(item)
    suspend fun deleteDelivery(id: Long): Int = repo.deleteDelivery(id)
}