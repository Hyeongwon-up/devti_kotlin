package hw.devti.domain.traffic.api

import io.swagger.annotations.Api
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/traffic")
@Api(value = "Traffic")
class TrafficController {
}