package com.example.hyunsikyoo.retrofit_example_kotlin.retrofit

import com.example.hyunsikyoo.retrofit_example_kotlin.model.GithubResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

class GithubApi {

    interface GithubApiImpl {
        @GET("/search/repositories")
        fun getRepoList(@Query("q") query: String): Observable<GithubResponseModel>
    }

    companion object {
        fun getRepoList(query: String): Observable<GithubResponseModel> {
            return RetrofitCreator.create(GithubApiImpl::class.java).getRepoList(query)
        }
    }
}