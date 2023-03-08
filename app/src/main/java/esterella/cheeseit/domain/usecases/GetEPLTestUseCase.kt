package esterella.cheeseit.domain.usecases

import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.repos.MainRepository

class GetEPLTestUseCase(private val repository: MainRepository) {

    suspend fun getEPLTest(questionId: Int): List<Main> {
        return repository.getEPLTest(questionId)
    }
}