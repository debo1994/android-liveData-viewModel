package com.thomaskioko.livedatademo.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.thomaskioko.livedatademo.db.MovieDao;
import com.thomaskioko.livedatademo.db.TmdbDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RoomModule {

    @Singleton
    @Provides
    TmdbDb providesRoomDatabase(Application app) {
        return Room.databaseBuilder(app, TmdbDb.class, "tmdb_db").build();
    }

    @Singleton
    @Provides
    MovieDao provideMovieDao(TmdbDb db){
        return db.movieDao();
    }
}
