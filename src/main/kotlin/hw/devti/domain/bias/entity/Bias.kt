package hw.devti.domain.bias.entity

import hw.devti.global.code.BiasType
import hw.devti.global.code.Pillar
import javax.persistence.*

@Entity
class Bias(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bias_id")
    private var id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "pillar")
    private var pillar: Pillar,

    @Enumerated(EnumType.STRING)
    @Column(name = "bias")
    private var bias: BiasType,

    @Column(name = "kr_bias")
    private var krBias: String,

    @Column(name = "en_bias")
    private var enBias: String

)