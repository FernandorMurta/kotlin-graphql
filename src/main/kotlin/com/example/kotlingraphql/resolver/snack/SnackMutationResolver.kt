package com.example.kotlingraphql.resolver.snack

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.kotlingraphql.entity.Snack
import com.example.kotlingraphql.repository.SnackRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class SnackMutationResolver(private val snackRepository: SnackRepository) : GraphQLMutationResolver {
    fun newSnack(name: String, amount: Float): Snack {
        val snack = Snack(name, amount)
        snack.id = UUID.randomUUID().toString()
        return snackRepository.save(snack)
    }

    fun deleteSnack(id: String): Boolean {
        snackRepository.deleteById(id)
        return true
    }

    fun updateSnack(id: String, amount: Float): Snack {
        val snack = snackRepository.findById(id)
        snack.ifPresent {
            it.amount = amount
            snackRepository.save(it)
        }
        return snack.get()
    }

}
