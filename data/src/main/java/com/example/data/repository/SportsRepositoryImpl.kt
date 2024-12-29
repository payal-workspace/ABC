package com.example.data.repository

import com.example.core.common.utils.Resource
import com.example.data.dataSource.SportsTable
import com.example.data.model.SportsCategoryEntity
import java.io.IOException
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val sportsDataSource: SportsTable
) : SportsRepository {

    override suspend fun getDetail(): Resource<SportsCategoryEntity> {
        return try {
            val response = sportsDataSource.getSportsCategoryData()
            Resource.Success(response)
        } catch (e: IOException) {
            Resource.Failure(e)
        }
    }

}
