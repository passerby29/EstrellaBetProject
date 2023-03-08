package esterella.cheeseit.domain.repos

import esterella.cheeseit.domain.models.Main

interface MainRepository {

    suspend fun getInternationalTest(questionId: Int): List<Main>
    suspend fun getEPLTest(questionId: Int): List<Main>
    suspend fun getEuropeTest(questionId: Int): List<Main>
    suspend fun getWorldTest(questionId: Int): List<Main>
}