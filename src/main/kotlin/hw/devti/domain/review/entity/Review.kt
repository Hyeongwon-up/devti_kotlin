package hw.devti.domain.review.entity

import javax.persistence.*

@Entity
class Review(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long ?,

  @Lob
  @Column(length = 500)
  var headLine : String,

  @Lob
  @Column(length = 500)
  var title: String?,

  @Lob
  @Column(length = 500)
  var contents: String?,

  var reviewType: String

)