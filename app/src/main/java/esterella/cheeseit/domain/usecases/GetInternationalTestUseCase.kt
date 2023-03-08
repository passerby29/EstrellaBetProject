package esterella.cheeseit.domain.usecases

import esterella.cheeseit.domain.models.International
import esterella.cheeseit.domain.repos.MainRepository

class GetInternationalTestUseCase(private val repository: MainRepository) {

    suspend fun getInternationalTest(): List<International> {
        return repository.getInternationalTest()
    }
}