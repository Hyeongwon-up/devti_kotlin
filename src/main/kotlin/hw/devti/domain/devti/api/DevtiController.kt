package hw.devti.domain.devti.api

import hw.devti.domain.answer.entity.AnswerAttribute
import hw.devti.domain.devti.dto.DevtiReqDto
import hw.devti.domain.devti.dto.DevtiResDto
import hw.devti.domain.devti.service.DevtiService
import hw.devti.global.code.BiasType
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/devti")
@Api(value = "Devti")
class DevtiController(
    private val devtiService: DevtiService
) {

    @PostMapping
    @ApiOperation(value = "답변 저장하여 결과 요청값 반환 받기")
    fun getDevtiByAnswer(@RequestBody answerAttributeList: List<AnswerAttribute>): ResponseEntity<DevtiReqDto> {
        return ResponseEntity.ok(devtiService.analysisAndCreateDevti(answerAttributeList))
    }


    @GetMapping("/result")
    @ApiOperation(value = "결과 요청값으로 결과 반환 받기")
    fun getDevtiByQueryString(
        @RequestParam("V") v: Int,
        @RequestParam("A") a: Int,
        @RequestParam("S") s: Int,
        @RequestParam("C") c: Int,
        @RequestParam("P") p: Int,
        @RequestParam("T") t: Int,
        @RequestParam("W") w: Int,
        @RequestParam("L") l: Int,
        @RequestParam("job") job: String?
    ): ResponseEntity<DevtiResDto> {
        val biasResult: HashMap<BiasType, Int> = HashMap<BiasType, Int>()
        biasResult.put(BiasType.V, v);
        biasResult.put(BiasType.A, a);
        biasResult.put(BiasType.S, s);
        biasResult.put(BiasType.C, c);
        biasResult.put(BiasType.P, p);
        biasResult.put(BiasType.T, t);
        biasResult.put(BiasType.W, w);
        biasResult.put(BiasType.L, l);
        return ResponseEntity.ok(devtiService.getDevtiByAnswer(biasResult, job!!))
    }
}