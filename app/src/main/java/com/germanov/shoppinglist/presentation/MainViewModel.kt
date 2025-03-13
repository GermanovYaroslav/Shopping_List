package com.germanov.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.germanov.shoppinglist.data.ShopListRepositoryImpl
import com.germanov.shoppinglist.domain.DeleteShopItemUseCase
import com.germanov.shoppinglist.domain.EditShopItemUseCase
import com.germanov.shoppinglist.domain.GetShopListUseCase
import com.germanov.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem)
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopItem(newItem)
    }
}
