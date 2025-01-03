package com.example.data.repository

import com.example.common.utils.Resource
import com.example.data.dataSource.SportsDataSource
import com.example.data.model.SportsCategoryEntity
import com.example.domain.dto.SportsCategoryDTO
import com.example.domain.dto.SportsCategoryDataDTO
import com.example.domain.dto.SportsCategoryListsDTO
import com.example.domain.repository.SportsRepository
import java.io.IOException
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val sportsDataSource: SportsDataSource
) : SportsRepository {

    override suspend fun getSportsCategories(): Resource<SportsCategoryDTO> {
        return try {
            val response = sportsDataSource.fetchSportsCategories()
            val domainDTO = mapEntityToDomainDTO(response)
            Resource.Success(domainDTO)
        } catch (e: IOException) {
            Resource.Failure(e)
        }
    }

    private fun mapEntityToDomainDTO(entity: SportsCategoryEntity): SportsCategoryDTO {
        return SportsCategoryDTO(
            data = entity.data.map {
                SportsCategoryDataDTO(
                    sportsCategoryTitle = it.sportsCategoryTitle,
                    sportsCategoryImageUrl = it.sportsCategoryImageUrl,
                    sportsCategoryItem = it.sportsCategoryItem?.map {
                        SportsCategoryListsDTO(
                            sportsTitle = it.sportsTitle,
                            sportsDescription = it.sportsDescription,
                            sportsImageUrl = it.sportsImageUrl
                        )
                    }
                )
            }
        )
    }
}
