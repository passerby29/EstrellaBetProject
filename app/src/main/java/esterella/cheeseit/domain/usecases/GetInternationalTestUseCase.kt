package esterella.cheeseit.domain.usecases

import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.domain.repos.MainRepository

class GetInternationalTestUseCase(private val repository: MainRepository) {

    suspend fun getInternationalTest(questionId: Int): List<Main> {
        return repository.getInternationalTest(questionId)
    }
}