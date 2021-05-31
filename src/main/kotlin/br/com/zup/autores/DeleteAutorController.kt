package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autores/{id}")
class DeleteAutorController(val repository: AutorRepository) {

    @Delete
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        val possivelAutor = repository.findById(id)

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        repository.deleteById(id)
        return HttpResponse.noContent()
    }

}