package com.onurkaragunlu.base_ui.mapper

import com.onurkaragunlu.base_domain.model.DomainModel

/**
 * Created by Onur Karagünlü on 9.06.2022.
 */
interface UIMapper<D : DomainModel, U : UIModel> {
    fun mapToUIModel(domainModel: D): U
}