package com.onuremren.googleyemekapp.model

import android.view.Menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.onuremren.googleyemekapp.data.DataSource
import java.text.NumberFormat

class OrderViewModel : ViewModel() {
    val menuItems = DataSource.menuItems

    private var previousMainCoursePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    private val _mainCourse = MutableLiveData<MenuItem?>()
    val mainCourse : LiveData<MenuItem?> = _mainCourse

    private val _side = MutableLiveData<MenuItem?>()
    val side : LiveData<MenuItem?> = _side

    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment : LiveData<MenuItem?> = _accompaniment

    private val _subTotal = MutableLiveData(0.0)
    val subtotal : LiveData<String> = Transformations.map(_subTotal){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _total = MutableLiveData(0.0)
    val total : LiveData<String> = Transformations.map(_total){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _tax = MutableLiveData(0.0)
    val tax : LiveData<String> = Transformations.map(_tax){
        NumberFormat.getCurrencyInstance().format(it)
    }
    private val taxRate = 0.08


    fun setEntree(entree: String) {
        // TODO: if _entree.value is not null, set the previous entree price to the current
        //  entree price.
        if (_mainCourse.value != null){
            previousMainCoursePrice = _mainCourse.value!!.price

        }

        // TODO: if _subtotal.value is not null subtract the previous entree price from the current
        //  subtotal value. This ensures that we only charge for the currently selected entree.

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousMainCoursePrice)

        }

        // TODO: set the current entree value to the menu item corresponding to the passed in string
        _mainCourse.value = menuItems.get(entree)



        // TODO: update the subtotal to reflect the price of the selected entree.
        updateSubtotal(_mainCourse.value!!.price)


    }
    fun setSide(side: String) {
        // TODO: if _side.value is not null, set the previous side price to the current side price.
        if (_side.value != null){
            previousSidePrice = _side.value!!.price
        }

        // TODO: if _subtotal.value is not null subtract the previous side price from the current

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousSidePrice
            )
        }
        //  subtotal value. This ensures that we only charge for the currently selected side.

        // TODO: set the current side value to the menu item corresponding to the passed in string

        _side.value = menuItems.get(side)
        // TODO: update the subtotal to reflect the price of the selected side.
        updateSubtotal(_side.value!!.price)
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {
        // TODO: if _accompaniment.value is not null, set the previous accompaniment price to the
        //  current accompaniment price.

        if (_accompaniment.value != null){
            previousAccompanimentPrice = _accompaniment.value!!.price

        }


        // TODO: if _accompaniment.value is not null subtract the previous accompaniment price from
        //  the current subtotal value. This ensures that we only charge for the currently selected
        //  accompaniment.

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousAccompanimentPrice)
        }

        // TODO: set the current accompaniment value to the menu item corresponding to the passed in
        //  string
        _accompaniment.value = menuItems.get(accompaniment)
        // TODO: update the subtotal to reflect the price of the selected accompaniment.
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        // TODO: if _subtotal.value is not null, update it to reflect the price of the recently
        //  added item.
        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.plus(itemPrice)
        } else{
            _subTotal.value = itemPrice
        }
        //  Otherwise, set _subtotal.value to equal the price of the item.

        // TODO: calculate the tax and resulting total

        calculateTaxAndTotal()
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        // TODO: set _tax.value based on the subtotal and the tax rate.
        _tax.value = (_subTotal.value)?.times(taxRate)
        // TODO: set the total based on the subtotal and _tax.value.

        _total.value = (_subTotal.value)?.plus(_tax.value!!)
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        // TODO: Reset all values associated with an order
        previousMainCoursePrice = 0.0
        previousSidePrice = 0.0
        previousAccompanimentPrice = 0.0
        _mainCourse.value = null
        _side.value = null
        _accompaniment.value = null
        _subTotal.value = 0.0
        _total.value = 0.0
        _tax.value = 0.0
    }

}