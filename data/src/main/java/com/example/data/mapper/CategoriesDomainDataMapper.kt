package com.example.data.mapper

import com.example.core.common.extensions.DataToDomainModelMapper
import com.example.data.model.SportsCategoryData
import com.example.data.model.SportsCategoryEntity
import com.example.data.model.SportsCategoryLists
import com.example.domain.model.SportsModel
import com.example.domain.model.SportsModelData
import com.example.domain.model.SportsModelLists
import javax.inject.Inject

class CategoriesDomainDataMapper @Inject constructor() :
    DataToDomainModelMapper<SportsCategoryEntity, SportsModel> {
    override fun mapToDomainModel(responseModel: SportsCategoryEntity?): SportsModel {
        val detailResponse = requireNotNull(responseModel)
        return SportsModel(
            data = dataToDomainModel(detailResponse.data),

        )
    }

    private fun dataToDomainModel(sportsTitle: List<SportsCategoryData>?): List<SportsModelData>? {
        return sportsTitle?.map {
            SportsModelData(
                sportsCategoryTitle = it.sportsCategoryTitle,
                sportsCategoryImageUrl = it.sportsCategoryImageUrl ,
                sportsCategoryItem = dataToDomainModelItem(it.sportsCategoryItem)
            )
        } ?: emptyList()
    }

    private fun dataToDomainModelItem(sportsTitle: List<SportsCategoryLists>?): List<SportsModelLists>? {
        return sportsTitle?.map {
            SportsModelLists(
                sportsImageUrl = it.sportsImageUrl,
                sportsTitle = it.sportsTitle,
                sportsDescription = it.sportsDescription,
            )
        } ?: emptyList()
    }

}

