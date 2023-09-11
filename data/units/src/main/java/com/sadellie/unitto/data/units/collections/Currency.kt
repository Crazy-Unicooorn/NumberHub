/*
 * Unitto is a unit converter for Android
 * Copyright (c) 2023 Elshan Agaev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sadellie.unitto.data.units.collections

import com.sadellie.unitto.core.base.R
import com.sadellie.unitto.data.model.unit.AbstractUnit
import com.sadellie.unitto.data.model.unit.NormalUnit
import com.sadellie.unitto.data.model.UnitGroup
import com.sadellie.unitto.data.units.MyUnitIDS
import java.math.BigDecimal

internal val currencyCollection: List<AbstractUnit> by lazy {
    listOf(
        NormalUnit(MyUnitIDS.currency_1inch,    BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_1inch,    R.string.currency_1inch_short),
        NormalUnit(MyUnitIDS.currency_ada,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ada,      R.string.currency_ada_short),
        NormalUnit(MyUnitIDS.currency_aed,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_aed,      R.string.currency_aed_short),
        NormalUnit(MyUnitIDS.currency_afn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_afn,      R.string.currency_afn_short),
        NormalUnit(MyUnitIDS.currency_algo,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_algo,     R.string.currency_algo_short),
        NormalUnit(MyUnitIDS.currency_all,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_all,      R.string.currency_all_short),
        NormalUnit(MyUnitIDS.currency_amd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_amd,      R.string.currency_amd_short),
        NormalUnit(MyUnitIDS.currency_ang,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ang,      R.string.currency_ang_short),
        NormalUnit(MyUnitIDS.currency_aoa,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_aoa,      R.string.currency_aoa_short),
        NormalUnit(MyUnitIDS.currency_ars,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ars,      R.string.currency_ars_short),
        NormalUnit(MyUnitIDS.currency_atom,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_atom,     R.string.currency_atom_short),
        NormalUnit(MyUnitIDS.currency_aud,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_aud,      R.string.currency_aud_short),
        NormalUnit(MyUnitIDS.currency_avax,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_avax,     R.string.currency_avax_short),
        NormalUnit(MyUnitIDS.currency_awg,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_awg,      R.string.currency_awg_short),
        NormalUnit(MyUnitIDS.currency_azn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_azn,      R.string.currency_azn_short),
        NormalUnit(MyUnitIDS.currency_bam,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bam,      R.string.currency_bam_short),
        NormalUnit(MyUnitIDS.currency_bbd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bbd,      R.string.currency_bbd_short),
        NormalUnit(MyUnitIDS.currency_bch,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bch,      R.string.currency_bch_short),
        NormalUnit(MyUnitIDS.currency_bdt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bdt,      R.string.currency_bdt_short),
        NormalUnit(MyUnitIDS.currency_bgn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bgn,      R.string.currency_bgn_short),
        NormalUnit(MyUnitIDS.currency_bhd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bhd,      R.string.currency_bhd_short),
        NormalUnit(MyUnitIDS.currency_bif,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bif,      R.string.currency_bif_short),
        NormalUnit(MyUnitIDS.currency_bmd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bmd,      R.string.currency_bmd_short),
        NormalUnit(MyUnitIDS.currency_bnb,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bnb,      R.string.currency_bnb_short),
        NormalUnit(MyUnitIDS.currency_bnd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bnd,      R.string.currency_bnd_short),
        NormalUnit(MyUnitIDS.currency_bob,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bob,      R.string.currency_bob_short),
        NormalUnit(MyUnitIDS.currency_brl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_brl,      R.string.currency_brl_short),
        NormalUnit(MyUnitIDS.currency_bsd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bsd,      R.string.currency_bsd_short),
        NormalUnit(MyUnitIDS.currency_btc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_btc,      R.string.currency_btc_short),
        NormalUnit(MyUnitIDS.currency_btn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_btn,      R.string.currency_btn_short),
        NormalUnit(MyUnitIDS.currency_busd,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_busd,     R.string.currency_busd_short),
        NormalUnit(MyUnitIDS.currency_bwp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bwp,      R.string.currency_bwp_short),
        NormalUnit(MyUnitIDS.currency_byn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_byn,      R.string.currency_byn_short),
        NormalUnit(MyUnitIDS.currency_byr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_byr,      R.string.currency_byr_short),
        NormalUnit(MyUnitIDS.currency_bzd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_bzd,      R.string.currency_bzd_short),
        NormalUnit(MyUnitIDS.currency_cad,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cad,      R.string.currency_cad_short),
        NormalUnit(MyUnitIDS.currency_cdf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cdf,      R.string.currency_cdf_short),
        NormalUnit(MyUnitIDS.currency_chf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_chf,      R.string.currency_chf_short),
        NormalUnit(MyUnitIDS.currency_chz,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_chz,      R.string.currency_chz_short),
        NormalUnit(MyUnitIDS.currency_clf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_clf,      R.string.currency_clf_short),
        NormalUnit(MyUnitIDS.currency_clp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_clp,      R.string.currency_clp_short),
        NormalUnit(MyUnitIDS.currency_cny,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cny,      R.string.currency_cny_short),
        NormalUnit(MyUnitIDS.currency_cop,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cop,      R.string.currency_cop_short),
        NormalUnit(MyUnitIDS.currency_crc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_crc,      R.string.currency_crc_short),
        NormalUnit(MyUnitIDS.currency_cro,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cro,      R.string.currency_cro_short),
        NormalUnit(MyUnitIDS.currency_cuc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cuc,      R.string.currency_cuc_short),
        NormalUnit(MyUnitIDS.currency_cup,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cup,      R.string.currency_cup_short),
        NormalUnit(MyUnitIDS.currency_cve,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_cve,      R.string.currency_cve_short),
        NormalUnit(MyUnitIDS.currency_czk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_czk,      R.string.currency_czk_short),
        NormalUnit(MyUnitIDS.currency_dai,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_dai,      R.string.currency_dai_short),
        NormalUnit(MyUnitIDS.currency_djf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_djf,      R.string.currency_djf_short),
        NormalUnit(MyUnitIDS.currency_dkk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_dkk,      R.string.currency_dkk_short),
        NormalUnit(MyUnitIDS.currency_doge,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_doge,     R.string.currency_doge_short),
        NormalUnit(MyUnitIDS.currency_dop,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_dop,      R.string.currency_dop_short),
        NormalUnit(MyUnitIDS.currency_dot,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_dot,      R.string.currency_dot_short),
        NormalUnit(MyUnitIDS.currency_dzd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_dzd,      R.string.currency_dzd_short),
        NormalUnit(MyUnitIDS.currency_egld,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_egld,     R.string.currency_egld_short),
        NormalUnit(MyUnitIDS.currency_egp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_egp,      R.string.currency_egp_short),
        NormalUnit(MyUnitIDS.currency_enj,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_enj,      R.string.currency_enj_short),
        NormalUnit(MyUnitIDS.currency_ern,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ern,      R.string.currency_ern_short),
        NormalUnit(MyUnitIDS.currency_etb,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_etb,      R.string.currency_etb_short),
        NormalUnit(MyUnitIDS.currency_etc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_etc,      R.string.currency_etc_short),
        NormalUnit(MyUnitIDS.currency_eth,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_eth,      R.string.currency_eth_short),
        NormalUnit(MyUnitIDS.currency_eur,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_eur,      R.string.currency_eur_short),
        NormalUnit(MyUnitIDS.currency_fil,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_fil,      R.string.currency_fil_short),
        NormalUnit(MyUnitIDS.currency_fjd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_fjd,      R.string.currency_fjd_short),
        NormalUnit(MyUnitIDS.currency_fkp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_fkp,      R.string.currency_fkp_short),
        NormalUnit(MyUnitIDS.currency_ftt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ftt,      R.string.currency_ftt_short),
        NormalUnit(MyUnitIDS.currency_gbp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gbp,      R.string.currency_gbp_short),
        NormalUnit(MyUnitIDS.currency_gel,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gel,      R.string.currency_gel_short),
        NormalUnit(MyUnitIDS.currency_ggp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ggp,      R.string.currency_ggp_short),
        NormalUnit(MyUnitIDS.currency_ghs,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ghs,      R.string.currency_ghs_short),
        NormalUnit(MyUnitIDS.currency_gip,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gip,      R.string.currency_gip_short),
        NormalUnit(MyUnitIDS.currency_gmd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gmd,      R.string.currency_gmd_short),
        NormalUnit(MyUnitIDS.currency_gnf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gnf,      R.string.currency_gnf_short),
        NormalUnit(MyUnitIDS.currency_grt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_grt,      R.string.currency_grt_short),
        NormalUnit(MyUnitIDS.currency_gtq,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gtq,      R.string.currency_gtq_short),
        NormalUnit(MyUnitIDS.currency_gyd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_gyd,      R.string.currency_gyd_short),
        NormalUnit(MyUnitIDS.currency_hkd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_hkd,      R.string.currency_hkd_short),
        NormalUnit(MyUnitIDS.currency_hnl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_hnl,      R.string.currency_hnl_short),
        NormalUnit(MyUnitIDS.currency_hrk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_hrk,      R.string.currency_hrk_short),
        NormalUnit(MyUnitIDS.currency_htg,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_htg,      R.string.currency_htg_short),
        NormalUnit(MyUnitIDS.currency_huf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_huf,      R.string.currency_huf_short),
        NormalUnit(MyUnitIDS.currency_icp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_icp,      R.string.currency_icp_short),
        NormalUnit(MyUnitIDS.currency_idr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_idr,      R.string.currency_idr_short),
        NormalUnit(MyUnitIDS.currency_ils,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ils,      R.string.currency_ils_short),
        NormalUnit(MyUnitIDS.currency_imp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_imp,      R.string.currency_imp_short),
        NormalUnit(MyUnitIDS.currency_inj,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_inj,      R.string.currency_inj_short),
        NormalUnit(MyUnitIDS.currency_inr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_inr,      R.string.currency_inr_short),
        NormalUnit(MyUnitIDS.currency_iqd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_iqd,      R.string.currency_iqd_short),
        NormalUnit(MyUnitIDS.currency_irr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_irr,      R.string.currency_irr_short),
        NormalUnit(MyUnitIDS.currency_isk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_isk,      R.string.currency_isk_short),
        NormalUnit(MyUnitIDS.currency_jep,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_jep,      R.string.currency_jep_short),
        NormalUnit(MyUnitIDS.currency_jmd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_jmd,      R.string.currency_jmd_short),
        NormalUnit(MyUnitIDS.currency_jod,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_jod,      R.string.currency_jod_short),
        NormalUnit(MyUnitIDS.currency_jpy,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_jpy,      R.string.currency_jpy_short),
        NormalUnit(MyUnitIDS.currency_kes,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kes,      R.string.currency_kes_short),
        NormalUnit(MyUnitIDS.currency_kgs,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kgs,      R.string.currency_kgs_short),
        NormalUnit(MyUnitIDS.currency_khr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_khr,      R.string.currency_khr_short),
        NormalUnit(MyUnitIDS.currency_kmf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kmf,      R.string.currency_kmf_short),
        NormalUnit(MyUnitIDS.currency_kpw,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kpw,      R.string.currency_kpw_short),
        NormalUnit(MyUnitIDS.currency_krw,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_krw,      R.string.currency_krw_short),
        NormalUnit(MyUnitIDS.currency_ksm,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ksm,      R.string.currency_ksm_short),
        NormalUnit(MyUnitIDS.currency_kwd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kwd,      R.string.currency_kwd_short),
        NormalUnit(MyUnitIDS.currency_kyd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kyd,      R.string.currency_kyd_short),
        NormalUnit(MyUnitIDS.currency_kzt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_kzt,      R.string.currency_kzt_short),
        NormalUnit(MyUnitIDS.currency_lak,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lak,      R.string.currency_lak_short),
        NormalUnit(MyUnitIDS.currency_lbp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lbp,      R.string.currency_lbp_short),
        NormalUnit(MyUnitIDS.currency_link,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_link,     R.string.currency_link_short),
        NormalUnit(MyUnitIDS.currency_lkr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lkr,      R.string.currency_lkr_short),
        NormalUnit(MyUnitIDS.currency_lrd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lrd,      R.string.currency_lrd_short),
        NormalUnit(MyUnitIDS.currency_lsl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lsl,      R.string.currency_lsl_short),
        NormalUnit(MyUnitIDS.currency_ltc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ltc,      R.string.currency_ltc_short),
        NormalUnit(MyUnitIDS.currency_ltl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ltl,      R.string.currency_ltl_short),
        NormalUnit(MyUnitIDS.currency_luna,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_luna,     R.string.currency_luna_short),
        NormalUnit(MyUnitIDS.currency_lvl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lvl,      R.string.currency_lvl_short),
        NormalUnit(MyUnitIDS.currency_lyd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_lyd,      R.string.currency_lyd_short),
        NormalUnit(MyUnitIDS.currency_mad,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mad,      R.string.currency_mad_short),
        NormalUnit(MyUnitIDS.currency_matic,    BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_matic,    R.string.currency_matic_short),
        NormalUnit(MyUnitIDS.currency_mdl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mdl,      R.string.currency_mdl_short),
        NormalUnit(MyUnitIDS.currency_mga,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mga,      R.string.currency_mga_short),
        NormalUnit(MyUnitIDS.currency_mkd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mkd,      R.string.currency_mkd_short),
        NormalUnit(MyUnitIDS.currency_mmk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mmk,      R.string.currency_mmk_short),
        NormalUnit(MyUnitIDS.currency_mnt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mnt,      R.string.currency_mnt_short),
        NormalUnit(MyUnitIDS.currency_mop,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mop,      R.string.currency_mop_short),
        NormalUnit(MyUnitIDS.currency_mro,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mro,      R.string.currency_mro_short),
        NormalUnit(MyUnitIDS.currency_mur,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mur,      R.string.currency_mur_short),
        NormalUnit(MyUnitIDS.currency_mvr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mvr,      R.string.currency_mvr_short),
        NormalUnit(MyUnitIDS.currency_mwk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mwk,      R.string.currency_mwk_short),
        NormalUnit(MyUnitIDS.currency_mxn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mxn,      R.string.currency_mxn_short),
        NormalUnit(MyUnitIDS.currency_myr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_myr,      R.string.currency_myr_short),
        NormalUnit(MyUnitIDS.currency_mzn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_mzn,      R.string.currency_mzn_short),
        NormalUnit(MyUnitIDS.currency_nad,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_nad,      R.string.currency_nad_short),
        NormalUnit(MyUnitIDS.currency_ngn,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ngn,      R.string.currency_ngn_short),
        NormalUnit(MyUnitIDS.currency_nio,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_nio,      R.string.currency_nio_short),
        NormalUnit(MyUnitIDS.currency_nok,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_nok,      R.string.currency_nok_short),
        NormalUnit(MyUnitIDS.currency_npr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_npr,      R.string.currency_npr_short),
        NormalUnit(MyUnitIDS.currency_nzd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_nzd,      R.string.currency_nzd_short),
        NormalUnit(MyUnitIDS.currency_omr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_omr,      R.string.currency_omr_short),
        NormalUnit(MyUnitIDS.currency_one,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_one,      R.string.currency_one_short),
        NormalUnit(MyUnitIDS.currency_pab,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pab,      R.string.currency_pab_short),
        NormalUnit(MyUnitIDS.currency_pen,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pen,      R.string.currency_pen_short),
        NormalUnit(MyUnitIDS.currency_pgk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pgk,      R.string.currency_pgk_short),
        NormalUnit(MyUnitIDS.currency_php,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_php,      R.string.currency_php_short),
        NormalUnit(MyUnitIDS.currency_pkr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pkr,      R.string.currency_pkr_short),
        NormalUnit(MyUnitIDS.currency_pln,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pln,      R.string.currency_pln_short),
        NormalUnit(MyUnitIDS.currency_pyg,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_pyg,      R.string.currency_pyg_short),
        NormalUnit(MyUnitIDS.currency_qar,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_qar,      R.string.currency_qar_short),
        NormalUnit(MyUnitIDS.currency_ron,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ron,      R.string.currency_ron_short),
        NormalUnit(MyUnitIDS.currency_rsd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_rsd,      R.string.currency_rsd_short),
        NormalUnit(MyUnitIDS.currency_rub,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_rub,      R.string.currency_rub_short),
        NormalUnit(MyUnitIDS.currency_rwf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_rwf,      R.string.currency_rwf_short),
        NormalUnit(MyUnitIDS.currency_sar,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sar,      R.string.currency_sar_short),
        NormalUnit(MyUnitIDS.currency_sbd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sbd,      R.string.currency_sbd_short),
        NormalUnit(MyUnitIDS.currency_scr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_scr,      R.string.currency_scr_short),
        NormalUnit(MyUnitIDS.currency_sdg,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sdg,      R.string.currency_sdg_short),
        NormalUnit(MyUnitIDS.currency_sek,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sek,      R.string.currency_sek_short),
        NormalUnit(MyUnitIDS.currency_sgd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sgd,      R.string.currency_sgd_short),
        NormalUnit(MyUnitIDS.currency_shib,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_shib,     R.string.currency_shib_short),
        NormalUnit(MyUnitIDS.currency_shp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_shp,      R.string.currency_shp_short),
        NormalUnit(MyUnitIDS.currency_sll,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sll,      R.string.currency_sll_short),
        NormalUnit(MyUnitIDS.currency_sol,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sol,      R.string.currency_sol_short),
        NormalUnit(MyUnitIDS.currency_sos,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_sos,      R.string.currency_sos_short),
        NormalUnit(MyUnitIDS.currency_srd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_srd,      R.string.currency_srd_short),
        NormalUnit(MyUnitIDS.currency_std,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_std,      R.string.currency_std_short),
        NormalUnit(MyUnitIDS.currency_svc,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_svc,      R.string.currency_svc_short),
        NormalUnit(MyUnitIDS.currency_syp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_syp,      R.string.currency_syp_short),
        NormalUnit(MyUnitIDS.currency_szl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_szl,      R.string.currency_szl_short),
        NormalUnit(MyUnitIDS.currency_thb,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_thb,      R.string.currency_thb_short),
        NormalUnit(MyUnitIDS.currency_theta,    BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_theta,    R.string.currency_theta_short),
        NormalUnit(MyUnitIDS.currency_tjs,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_tjs,      R.string.currency_tjs_short),
        NormalUnit(MyUnitIDS.currency_tmt,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_tmt,      R.string.currency_tmt_short),
        NormalUnit(MyUnitIDS.currency_tnd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_tnd,      R.string.currency_tnd_short),
        NormalUnit(MyUnitIDS.currency_top,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_top,      R.string.currency_top_short),
        NormalUnit(MyUnitIDS.currency_trx,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_trx,      R.string.currency_trx_short),
        NormalUnit(MyUnitIDS.currency_try,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_try,      R.string.currency_try_short),
        NormalUnit(MyUnitIDS.currency_ttd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ttd,      R.string.currency_ttd_short),
        NormalUnit(MyUnitIDS.currency_twd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_twd,      R.string.currency_twd_short),
        NormalUnit(MyUnitIDS.currency_tzs,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_tzs,      R.string.currency_tzs_short),
        NormalUnit(MyUnitIDS.currency_uah,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_uah,      R.string.currency_uah_short),
        NormalUnit(MyUnitIDS.currency_ugx,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_ugx,      R.string.currency_ugx_short),
        NormalUnit(MyUnitIDS.currency_uni,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_uni,      R.string.currency_uni_short),
        NormalUnit(MyUnitIDS.currency_usd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_usd,      R.string.currency_usd_short),
        NormalUnit(MyUnitIDS.currency_usdc,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_usdc,     R.string.currency_usdc_short),
        NormalUnit(MyUnitIDS.currency_usdt,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_usdt,     R.string.currency_usdt_short),
        NormalUnit(MyUnitIDS.currency_uyu,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_uyu,      R.string.currency_uyu_short),
        NormalUnit(MyUnitIDS.currency_uzs,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_uzs,      R.string.currency_uzs_short),
        NormalUnit(MyUnitIDS.currency_vef,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_vef,      R.string.currency_vef_short),
        NormalUnit(MyUnitIDS.currency_vet,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_vet,      R.string.currency_vet_short),
        NormalUnit(MyUnitIDS.currency_vnd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_vnd,      R.string.currency_vnd_short),
        NormalUnit(MyUnitIDS.currency_vuv,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_vuv,      R.string.currency_vuv_short),
        NormalUnit(MyUnitIDS.currency_wbtc,     BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_wbtc,     R.string.currency_wbtc_short),
        NormalUnit(MyUnitIDS.currency_wst,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_wst,      R.string.currency_wst_short),
        NormalUnit(MyUnitIDS.currency_xaf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xaf,      R.string.currency_xaf_short),
        NormalUnit(MyUnitIDS.currency_xag,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xag,      R.string.currency_xag_short),
        NormalUnit(MyUnitIDS.currency_xau,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xau,      R.string.currency_xau_short),
        NormalUnit(MyUnitIDS.currency_xcd,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xcd,      R.string.currency_xcd_short),
        NormalUnit(MyUnitIDS.currency_xdr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xdr,      R.string.currency_xdr_short),
        NormalUnit(MyUnitIDS.currency_xlm,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xlm,      R.string.currency_xlm_short),
        NormalUnit(MyUnitIDS.currency_xmr,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xmr,      R.string.currency_xmr_short),
        NormalUnit(MyUnitIDS.currency_xof,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xof,      R.string.currency_xof_short),
        NormalUnit(MyUnitIDS.currency_xpf,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xpf,      R.string.currency_xpf_short),
        NormalUnit(MyUnitIDS.currency_xrp,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_xrp,      R.string.currency_xrp_short),
        NormalUnit(MyUnitIDS.currency_yer,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_yer,      R.string.currency_yer_short),
        NormalUnit(MyUnitIDS.currency_zar,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_zar,      R.string.currency_zar_short),
        NormalUnit(MyUnitIDS.currency_zmk,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_zmk,      R.string.currency_zmk_short),
        NormalUnit(MyUnitIDS.currency_zmw,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_zmw,      R.string.currency_zmw_short),
        NormalUnit(MyUnitIDS.currency_zwl,      BigDecimal.ONE, UnitGroup.CURRENCY, R.string.currency_zwl,      R.string.currency_zwl_short),
    )
}
