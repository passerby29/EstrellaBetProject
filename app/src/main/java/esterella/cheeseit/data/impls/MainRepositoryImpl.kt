package esterella.cheeseit.data.impls

import android.app.Application
import esterella.cheeseit.data.room.EsterellaAppDB
import esterella.cheeseit.data.room.Mapper
import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.repos.MainRepository

class MainRepositoryImpl(application: Application) : MainRepository {

    private val internationalDao = EsterellaAppDB.getDB(application).getInternationalDao()
    private val eplDao = EsterellaAppDB.getDB(application).getEPLDao()
    private val europeDao = EsterellaAppDB.getDB(application).getEuropeDao()
    private val worldDao = EsterellaAppDB.getDB(application).getWorldDao()
    private val mapper = Mapper()
    override suspend fun getInternationalTest(questionId: Int): List<Main> {
        val entity = internationalDao.getInternationalTest(questionId)
        return mapper.mapListDbModelInternational(entity)
    }

    override suspend fun getEPLTest(questionId: Int): List<Main> {
        val entity = eplDao.getEPLTest(questionId)
        return mapper.mapListDbModelEPL(entity)
    }

    override suspend fun getEuropeTest(questionId: Int): List<Main> {
        val entity = europeDao.getEuropeTest(questionId)
        return mapper.mapListDbModelEurope(entity)
    }

    override suspend fun getWorldTest(questionId: Int): List<Main> {
        val entity = worldDao.getWorldTest(questionId)
        return mapper.mapListDbModelWorld(entity)
    }
}