/*
 * Created by Piotr Kostecki on 21.12.18 10:26
 */

package com.launch.spicycoin.domain.dataclass

import com.coinpaprika.apiclient.entity.TagEntity
import com.coinpaprika.apiclient.entity.TeamMemberEntity
import com.coinpaprika.apiclient.entity.TickerEntity

data class SearchEntity(val currencies: MutableList<TickerEntity>,
                        val icos: MutableList<CoinEntity>,
                        val people: MutableList<TeamMemberEntity>,
                        val tags: MutableList<TagEntity>)