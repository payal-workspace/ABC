package com.example.data.repository

import com.example.core.common.utils.Resource
import com.example.data.model.SportsCategoryEntity

interface SportsRepository {
    suspend fun getDetail(): Resource<SportsCategoryEntity>
}