package esterella.cheeseit.data.impls

import android.app.Application
import esterella.cheeseit.data.room.EsterellaAppDB
import esterella.cheeseit.data.room.InternationalMapper
import esterella.cheeseit.domain.models.International
import esterella.cheeseit.domain.repos.MainRepository

class MainRepositoryImpl(application: Application) : MainRepository {

    private val internationalDao = EsterellaAppDB.getDB(application).getInternationalDao()
    private val internationalMapper = InternationalMapper()
    override suspend fun getInternationalTest(): List<International> {
        val entity = internationalDao.getQuestion1()
        return internationalMapper.mapListDbModel(entity)
    }
}