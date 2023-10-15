package org.xapps.service.testservice.v1.seeders

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.xapps.service.testservice.v1.entities.User
import org.xapps.service.testservice.v1.repositories.AddressRepository
import org.xapps.service.testservice.v1.repositories.CompanyRepository
import org.xapps.service.testservice.v1.repositories.GeoRepository
import org.xapps.service.testservice.v1.repositories.UserRepository
import org.xapps.service.testservice.v1.utils.lazyLogger
import java.nio.charset.StandardCharsets
import java.util.*


@Component
class DatabaseSeeder @Autowired constructor(
    private val userRepository: UserRepository,
    private val addressRepository: AddressRepository,
    private val companyRepository: CompanyRepository,
    private val geoRepository: GeoRepository
) {

    companion object {
        private val logger by lazyLogger()
    }

    @EventListener
    fun seed(context: ContextRefreshedEvent) {
        userRepository.deleteAll()
        companyRepository.deleteAll()
        addressRepository.deleteAll()
        geoRepository.deleteAll()

        val inputStream = object{}.javaClass.getClassLoader().getResourceAsStream("test-data.json")

        if (inputStream != null) {
            Scanner(inputStream, StandardCharsets.UTF_8.name()).use { scanner ->
                val fileContent: String = scanner.useDelimiter("\\A").next()

                ObjectMapper().readValue(fileContent, object : TypeReference<List<User>>() {}).apply {
                    this.map { it.address!!.geo }.apply { geoRepository.saveAll(this) }
                    this.map { it.address }.apply { addressRepository.saveAll(this) }
                    this.map { it.company }.apply { companyRepository.saveAll(this) }
                    userRepository.saveAll(this)
                }
            }
        } else {
            logger.error("Seed data file not found")
        }
    }

}