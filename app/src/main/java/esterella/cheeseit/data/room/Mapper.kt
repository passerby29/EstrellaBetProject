package esterella.cheeseit.data.room

import esterella.cheeseit.domain.models.Main

class Mapper {

    fun mapListDbModelInternational(list: List<InternationalEntity>) = list.map {
        mapDbModelToEntityInternational(it)
    }

    private fun mapDbModelToEntityInternational(internationalEntity: InternationalEntity) = Main(
        mId = internationalEntity.mId,
        mQuestion = internationalEntity.mQuestion,
        mQuestionId = internationalEntity.mQuestionId,
        mAnswer = internationalEntity.mAnswer,
        mResult = internationalEntity.mResult,
    )

    fun mapListDbModelEPL(list: List<EPLEntity>) = list.map {
        mapDbModelToEntityEPL(it)
    }

    private fun mapDbModelToEntityEPL(eplEntity: EPLEntity) = Main(
        mId = eplEntity.mId,
        mQuestion = eplEntity.mQuestion,
        mQuestionId = eplEntity.mQuestionId,
        mAnswer = eplEntity.mAnswer,
        mResult = eplEntity.mResult,
    )

    fun mapListDbModelEurope(list: List<EuropeEntity>) = list.map {
        mapDbModelToEntityEurope(it)
    }

    private fun mapDbModelToEntityEurope(europeEntity: EuropeEntity) = Main(
        mId = europeEntity.mId,
        mQuestion = europeEntity.mQuestion,
        mQuestionId = europeEntity.mQuestionId,
        mAnswer = europeEntity.mAnswer,
        mResult = europeEntity.mResult,
    )

    fun mapListDbModelWorld(list: List<WorldEntity>) = list.map {
        mapDbModelToEntityWorld(it)
    }

    private fun mapDbModelToEntityWorld(worldEntity: WorldEntity) = Main(
        mId = worldEntity.mId,
        mQuestion = worldEntity.mQuestion,
        mQuestionId = worldEntity.mQuestionId,
        mAnswer = worldEntity.mAnswer,
        mResult = worldEntity.mResult,
    )
}