package com.onurkaragunlu.base_data.extension.mapper

import com.onurkaragunlu.base_domain.model.DomainModel


/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
interface DataMapper<R : ResponseModel, D:DomainModel > {
    fun mapToDomainModel(responseModel: R): D
}