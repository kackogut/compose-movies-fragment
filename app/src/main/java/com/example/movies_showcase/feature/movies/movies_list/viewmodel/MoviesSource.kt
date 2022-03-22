package com.example.movies_showcase.feature.movies.movies_list.viewmodel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.first

class MoviesSource(private val moviesRepository: MoviesRepository) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val nextPage = params.key ?: 1
        val movieListResponse = moviesRepository.getMoviesList(nextPage).first()

        return when (movieListResponse) {
            is ApiResponse.Success -> {
                LoadResult.Page(
                    data = movieListResponse.data,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = nextPage.plus(1)
                )
            }
            is ApiResponse.Error -> {
                LoadResult.Error(movieListResponse.throwable)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}
