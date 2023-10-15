package org.xapps.service.testservice.v1.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.xapps.service.testservice.v1.entities.Address

@Repository
interface AddressRepository : JpaRepository<Address, Long>
