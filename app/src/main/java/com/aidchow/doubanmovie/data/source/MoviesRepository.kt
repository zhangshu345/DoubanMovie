package com.aidchow.doubanmovie.data.source

import com.aidchow.doubanmovie.data.Movie

/**
 * Created by aidchow on 17-5-27.
 */
class MoviesRepository private constructor(moviesRemoteDataSource: MoviesDataSource) : MoviesDataSource {


    private val mMoviesRemoteDataSource: MoviesDataSource = moviesRemoteDataSource

    companion object {
        private var INSTANCE: MoviesRepository? = null


        fun getInstance(moviesRemoteDataSource: MoviesDataSource): MoviesRepository {
            if (INSTANCE == null) {
                INSTANCE = MoviesRepository(moviesRemoteDataSource)
            }
            return INSTANCE as MoviesRepository
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun getMovies(queryType: String, callBack: MoviesDataSource.LoadMoviesCallBack) {
        mMoviesRemoteDataSource.getMovies(queryType, object : MoviesDataSource.LoadMoviesCallBack {
            override fun onMoviesLoaded(movies: Movie) {
                callBack.onMoviesLoaded(movies)
            }

            override fun onMoviesLoadFailed(message: String) {
                callBack.onMoviesLoadFailed(message)
            }
        })
    }

    override fun loadMoreMovies(queryType: String, start: Int, callBack: MoviesDataSource.LoadMoviesCallBack) {
        mMoviesRemoteDataSource.loadMoreMovies(queryType, start, object : MoviesDataSource.LoadMoviesCallBack {
            override fun onMoviesLoaded(movies: Movie) {
                callBack.onMoviesLoaded(movies)
            }

            override fun onMoviesLoadFailed(message: String) {
                callBack.onMoviesLoadFailed(message)
            }
        })
    }

    override fun loadTop250Movies(start: Int, callBack: MoviesDataSource.LoadMoviesCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchMovies(queryText: String, callBack: MoviesDataSource.LoadMoviesCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadMovieSubject(movieId: Int, callBack: MoviesDataSource.LoadMovieSubjectCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadCelebrity(starId: Int, callBack: MoviesDataSource.LoadCelebirtyCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}