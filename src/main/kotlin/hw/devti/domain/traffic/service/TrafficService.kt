package hw.devti.domain.traffic.service

import hw.devti.domain.traffic.dao.TrafficRepository
import hw.devti.domain.traffic.entity.Traffic
import hw.devti.global.code.TestType
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
@Slf4j
class TrafficService(
    private val trafficRepository: TrafficRepository
) {

    fun getLastTraffic(): Traffic {
        var lastTraffic = trafficRepository.findTopByOrderByIdDesc()

        if(lastTraffic == null) {
            lastTraffic = Traffic(testType = TestType.TYPE_COMMON_3)
        }

        return lastTraffic
    }

    fun saveTraffic(traffic: Traffic): Traffic {
        return trafficRepository.save(traffic)
    }


}