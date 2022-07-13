package com.newcore.easyrecyclergenerator

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

interface RvListFactory {
    /**
     * binding : binding inflate functions
     *      ex: binding = ItemViewBinding::inflate  where ItemView is layout
     * children :  recyclerView data
     * generator : used for bind data into view
     *      ex: adding onClickListener or setText to view etc...
     *
     * return ViewGeneratorHolder it is reference of data in recycler just used for
     * getting data or view or remove it from recycler
     */
    fun <T : ViewBinding, L> addItem(
        binding: (LayoutInflater) -> T,
        child: L,
        generator: (T, L) -> Unit,
    ): ViewGeneratorHolder<T, L>


    /**
     * layoutId : layout resource id
     *      ex: layoutId = R.layout.layout_id
     * data : recyclerView data
     * generator : function used for bind data into view
     *      ex: adding onClickListener or setText to view etc...
     *
     * return ViewGeneratorHolder it is reference of data in recycler just used for
     *      getting data or view or remove it from recycler
     */
    fun <T : View, L> addItem(
        @LayoutRes layoutId: Int,
        child: L,
        generator: (T, L) -> Unit,
    ): ViewGeneratorHolder<T, L>

    /**
     * it give you more flexibility to create view
     * item : object of ViewGeneratorHolder
     *
     * return object of ViewGeneratorHolder it is reference of data in recycler just used for
     *      getting data or view or remove it from recycler
     */
    fun <T, L> addItem(
        item: ViewGeneratorHolder<T, L>,
    ): ViewGeneratorHolder<T, L>

    /**
     * binding : binding inflate functions
     *      ex: binding = ItemViewBinding::inflate  where ItemView is layout
     * children : list of recyclerView data
     * generator : used for bind data into view
     *      ex: adding onClickListener or setText to view etc...
     *
     * return list of ViewGeneratorHolder it is reference of data in recycler just used for
     * getting data or view or remove it from recycler
     */
    fun <T : ViewBinding, L> listBuilder(
        binding: (LayoutInflater) -> T,
        children: List<L>,
        generator: (T, L) -> Unit,
    ): List<ViewGeneratorHolder<T, L>>

    /**
     * layoutId : layout resource id
     *      ex: layoutId = R.layout.layout_id
     * children : list of recyclerView data
     * generator : function used for bind data into view
     *      ex: adding onClickListener or setText to view etc...
     *
     * return list of ViewGeneratorHolder it is reference of data in recycler just used for
     * getting data or view or remove it from recycler
     */

    fun <T : View, L> listBuilder(
        @LayoutRes layoutId: Int,
        children: List<L>,
        generator: (T, L) -> Unit,
    ): List<ViewGeneratorHolder<T, L>>

    /**
     * it give you more flexibility to create view
     * items : list of ViewGeneratorHolder
     *
     * return list of ViewGeneratorHolder it is reference of data in recycler just used for
     *      getting data or view or remove it from recycler
     */
    fun <T, L> addItems(
        items: List<ViewGeneratorHolder<T, L>>,
    ): List<ViewGeneratorHolder<T, L>>

    fun removeItemWithViewGenerator(viewGenerator: ViewGeneratorHolder<*, *>)
    fun removeItemWithPosition(position: Int)
    fun removeItemWithData(data: Any)
    fun start(recyclerView: RecyclerView, customLayoutManager: RecyclerView.LayoutManager? = null)
}