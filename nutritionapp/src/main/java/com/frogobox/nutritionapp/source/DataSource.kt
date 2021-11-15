package com.frogobox.nutritionapp.source

import android.content.Context
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.model.news.SourceResponse

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 18/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.source
 *
 */
interface DataSource {

    // API Server ----------------------------------------------------------------------------------

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Get Top Headline
    suspend fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: GetRemoteCallback<ArticleResponse>
    )

    // Get Everythings
    suspend fun getEverythings(
        apiKey: String,
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: GetRemoteCallback<ArticleResponse>
    )

    // Get Sources
    suspend fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: GetRemoteCallback<SourceResponse>
    )

    // Room Database -------------------------------------------------------------------------------

    fun saveRoomFavorite(data: Favorite) : Boolean

    // Get
    fun getRoomFavorite(callback: GetRoomDataCallBack<List<Favorite>>)

    // Update
    fun updateRoomFavorite(tableId: Int, title: String, description: String, dateTime: String) : Boolean

    // Delete
    fun deleteRoomFavorite(tableId: Int) : Boolean

    // Nuke
    fun nukeRoomFavorite() : Boolean
    // ---------------------------------------------------------------------------------------------

    // Interface Helper ---------------------------------------------------------------------------

    // Response Callback
    interface GetRemoteCallback<T> : NutriResponse.DataResponse<T>

    // Save
    interface SaveRoomDataCallBack<T>: NutriResponse.DataResponse<T>
    interface SavePrefCallBack<T>: NutriResponse.DataResponse<T>

    // Get
    interface GetRoomDataCallBack<T> : NutriResponse.DataResponse<T>

    // Update
    interface UpdateRoomDataCallBack<T> : NutriResponse.DataResponse<T>

    // Delete
    interface DeleteRoomDataCallBack<T> : NutriResponse.DataResponse<T>
    // ---------------------------------------------------------------------------------------------

}