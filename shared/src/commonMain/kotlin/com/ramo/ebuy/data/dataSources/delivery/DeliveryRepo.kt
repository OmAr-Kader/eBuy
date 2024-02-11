package com.ramo.ebuy.data.dataSources.delivery

import com.ramo.ebuy.data.model.DeliveryProcess

interface DeliveryRepo {
    suspend fun getDeliveryOnId(id: Long): DeliveryProcess?
    suspend fun addNewDelivery(item: DeliveryProcess): DeliveryProcess?
    suspend fun editDelivery(item: DeliveryProcess): DeliveryProcess?
    suspend fun deleteDelivery(id: Long): Int
}