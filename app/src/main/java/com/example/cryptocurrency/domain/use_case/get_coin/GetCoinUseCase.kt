package com.example.cryptocurrency.domain.use_case.get_coin

import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.data.remote.dto.toCoin
import com.example.cryptocurrency.data.remote.dto.toCoinDetail
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

//UseCase should only have one public function and that is the function to execute that use case
//here, the case to get coins, in the other case to get the coin details
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    //We are overriding the invoke func ( not everyone do this )
    //we return a flow bcos we want to emit multiple value over a period of time (loading usecase, progress bar)
    //We have to emit if its successful or error, that's why we have "Resource"

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try{
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        } catch(e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}