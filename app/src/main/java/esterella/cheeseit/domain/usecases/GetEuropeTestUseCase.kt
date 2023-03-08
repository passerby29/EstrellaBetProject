package esterella.cheeseit.domain.usecases

import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.repos.MainRepository

class GetEuropeTestUseCase(private val repository: MainRepository) {

    suspend fun getEuropeTest(questionId: Int): List<Main> {
        return repository.getEuropeTest(questionId)
    }
}