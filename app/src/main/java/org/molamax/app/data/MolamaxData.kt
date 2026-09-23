package org.molamax.app.data

object MolamaxData {

    const val companyName = "Molamax"
    const val heroTagline = "Better animal health.\nBetter farm performance."
    const val heroEyebrow = "Nutrition that works in the real world"
    const val heroBody = "Trusted probiotic, vitamin, mineral and enzyme solutions for farmers " +
        "across Southern Africa, backed by practical technical support."

    const val aboutTitle = "Built for the work farmers do"
    const val aboutBody = "Molamax supplies targeted probiotic, vitamin, mineral and enzyme " +
        "formulas for dairy cattle, goats, layers, broilers, Kienyeji flocks, sheep and calves. " +
        "We believe better outcomes come from practical products, honest guidance and support " +
        "that understands local farming conditions."

    const val generalPhone = "+263 778 980 115"
    const val zimbabwePhone = "+263 716 108 679"
    const val botswanaPhone = "+267 72 162 603"
    const val email = "info@molamax.org"
    const val workingHours = "Mon\u2013Fri, 8:00\u201318:00"
    const val whatsappNumber = "263778980115"

    val categories = listOf(
        ProductCategory("dairy", "Dairy", "\uD83D\uDC04",
            "Rumen fermentation and probiotic formulas built around milk volume, butterfat and lactation persistence."),
        ProductCategory("poultry", "Poultry", "\uD83D\uDC14",
            "Natural formulas for layers, broilers, Kienyeji flocks and day-old chick immunity."),
        ProductCategory("pig", "Pig", "\uD83D\uDC16",
            "Practical nutritional support for healthy pig growth and recovery."),
        ProductCategory("livestock", "Livestock & Ruminants", "\uD83D\uDC11",
            "Probiotic, vitamin, mineral and enzyme support for cattle, calves, sheep and goats."),
        ProductCategory("others", "Other Solutions", "\uD83C\uDF31",
            "Specialized probiotic, compost, silage and organic plant nutrition solutions.")
    )

    private fun catName(slug: String) = categories.first { it.slug == slug }.name

    val products = listOf(
        Product(
            "livestock-booster", "Livestock Booster", "livestock", catName("livestock"),
            "Livestock nutrition support for healthier animals and improved farm performance.",
            "Nutritional support for cattle, sheep and goats. Confirm final claims and feeding " +
                "directions against the approved product label.",
            listOf("Cattle", "Sheep", "Goats"),
            listOf("Livestock nutrition support", "Daily animal health support", "Farm productivity support")
        ),
        Product(
            "pig-booster", "Pig Booster", "pig", catName("pig"),
            "Nutritional support for pig growth and production performance.",
            "Pig nutrition support for use within a balanced feeding programme. Confirm final " +
                "claims and feeding directions against the approved product label.",
            listOf("Piglets", "Growers", "Finishers", "Breeding pigs"),
            listOf("Pig growth support", "Feed programme support", "Animal condition support")
        ),
        Product(
            "milk-booster", "Milk Booster", "dairy", catName("dairy"),
            "Dairy nutrition support for milk production and animal condition.",
            "Dairy nutrition support for lactating animals. Confirm final claims and feeding " +
                "directions against the approved product label.",
            listOf("Dairy cattle", "Lactating cows", "Dairy goats"),
            listOf("Milk production support", "Lactation support", "Dairy animal nutrition")
        ),
        Product(
            "mineral-lick", "Mineral Lick", "livestock", catName("livestock"),
            "Mineral supplementation support for livestock and grazing animals.",
            "Mineral supplementation for livestock where additional mineral support is required. " +
                "Confirm final claims and directions against the approved product label.",
            listOf("Cattle", "Sheep", "Goats", "Grazing livestock"),
            listOf("Mineral supplementation", "Grazing support", "Livestock condition support")
        ),
        Product(
            "livestock-probiotic", "Livestock Probiotic", "livestock", catName("livestock"),
            "Probiotic support for livestock digestive programmes.",
            "A livestock probiotic for cattle, sheep and goats. Confirm final claims and " +
                "directions against the approved product label.",
            listOf("Cattle", "Calves", "Sheep", "Goats"),
            listOf("Probiotic support", "Digestive programme support", "Ruminant nutrition")
        ),
        Product(
            "calf-winner", "Calf Winner", "livestock", catName("livestock"),
            "Nutritional support for calf development and early-life management.",
            "Calf nutrition support for young animals. Confirm final claims and directions " +
                "against the approved product label.",
            listOf("Calves", "Young dairy cattle", "Young beef cattle"),
            listOf("Calf development support", "Early-life nutrition", "Growth programme support")
        ),
        Product(
            "molamax-plus-liquid-booster", "Molamax Plus Liquid Booster", "poultry", catName("poultry"),
            "Liquid nutritional support for poultry production programmes.",
            "Liquid poultry nutrition support for use within an approved flock programme. Confirm " +
                "final claims and directions against the approved product label.",
            listOf("Broilers", "Layers", "Pullets", "Kienyeji birds"),
            listOf("Liquid poultry support", "Flock nutrition support", "Production programme support")
        ),
        Product(
            "molamax-plus-powder", "Molamax Plus Powder", "poultry", catName("poultry"),
            "Powdered nutritional support for poultry production programmes.",
            "Powdered poultry nutrition support for use within an approved flock programme. " +
                "Confirm final claims and directions against the approved product label.",
            listOf("Broilers", "Layers", "Pullets", "Kienyeji birds"),
            listOf("Powdered poultry support", "Flock nutrition support", "Production programme support")
        ),
        Product(
            "no-stress-chick-plus", "No Stress Chick Plus", "poultry", catName("poultry"),
            "Early-life nutritional support for chicks during brooding.",
            "Chick support for brooding and flock management periods. Confirm final claims and " +
                "directions against the approved product label.",
            listOf("Day-old chicks", "Broilers", "Pullets", "Kienyeji chicks"),
            listOf("Chick support", "Brooding programme support", "Early-life nutrition")
        ),
        Product(
            "molamax-fountain-layers-supplement", "Molamax Fountain Layers Supplement", "poultry", catName("poultry"),
            "Layer nutrition support for productive poultry flocks.",
            "A layer supplement for use within an approved management programme. Confirm final " +
                "claims and directions against the approved product label.",
            listOf("Layers", "Commercial layers", "Breeding birds", "Kienyeji layers"),
            listOf("Layer nutrition support", "Flock productivity support", "Egg production programme")
        ),
        Product(
            "silage-probiotics", "Silage Probiotics", "others", catName("others"),
            "Probiotic support for silage preparation and forage management.",
            "Silage probiotic support for approved forage preservation programmes. Confirm final " +
                "claims and application directions against the approved product label.",
            listOf("Dairy farms", "Beef farms", "Livestock farms"),
            listOf("Silage programme support", "Forage management", "Feed preservation support")
        ),
        Product(
            "biocompost-probiotics", "Biocompost Probiotics", "others", catName("others"),
            "Probiotic support for composting and farm waste management.",
            "Probiotic support for approved composting programmes. Confirm final claims and " +
                "application directions against the approved product label.",
            listOf("Farms", "Agricultural businesses", "Organic production systems"),
            listOf("Compost programme support", "Organic waste management", "Farm sustainability")
        ),
        Product(
            "nitro-fix-garden-plus", "Nitro-Fix Garden Plus", "others", catName("others"),
            "Garden and plant nutrition support for horticultural programmes.",
            "Garden nutrition support for approved horticultural applications. Confirm final " +
                "claims and application directions against the approved product label.",
            listOf("Gardens", "Horticulture", "Vegetable production"),
            listOf("Garden nutrition support", "Plant growth programme", "Horticultural support")
        ),
        Product(
            "molamax-organic-foliar-fertilizer", "Molamax Organic Foliar Fertilizer", "others", catName("others"),
            "Organic foliar nutrition support for crop production.",
            "Organic foliar fertilizer for approved agricultural and horticultural applications. " +
                "Confirm final claims and directions against the approved product label.",
            listOf("Crops", "Gardens", "Horticulture", "Agricultural production"),
            listOf("Foliar nutrition support", "Organic crop programme", "Plant health support")
        )
    )

    val articles = listOf(
        Article("reading-a-feed-tag", "Knowledge Centre", "How to read a feed tag before you buy",
            "Crude protein, fibre, and ash percentages tell you more than the brand name does \u2014 here is what to check first."),
        Article("transitioning-dairy-calves", "Dairy", "Transitioning calves from milk to solid feed",
            "A rough transition at weaning shows up in growth rates for months."),
        Article("broiler-feed-conversion", "Poultry", "Three habits that quietly wreck broiler feed conversion",
            "Feed conversion ratio is decided in the first two weeks more than any other stage."),
        Article("mineral-deficiency-signs", "Livestock", "Six visible signs of mineral deficiency in cattle",
            "Rough coats, reduced fertility and slow healing are often mineral issues."),
        Article("weaner-pig-nutrition", "Pig", "Getting weaner pigs through the post-weaning dip",
            "Almost every weaner loses condition in the days after weaning.")
    )

    val faqs = listOf(
        Faq("General", "How do I know which feed is right for my animals?",
            "It depends on species, age and production stage. WhatsApp or call our team and describe your herd or flock."),
        Faq("General", "Do you sell directly to farmers or only through stockists?",
            "Both. You can buy through listed stockists or contact us directly for bulk or first-time orders."),
        Faq("Storage", "How should feed be stored to avoid spoilage?",
            "Keep bags off the ground on pallets, in a dry, ventilated space away from direct sunlight."),
        Faq("Support", "Do you offer technical support after purchase?",
            "Yes. Our Knowledge Centre and contact line support feeding and formulation questions.")
    )

    val stockists = listOf(
        Stockist("Molamax Shop \u2014 Ultimate Mall", "Zimbabwe", "Harare", zimbabwePhone),
        Stockist("Molamax Botswana", "Botswana", "Countrywide", botswanaPhone),
        Stockist("Molamax Botswana \u2014 Maun", "Botswana", "Maun", botswanaPhone),
        Stockist("Molamax Botswana \u2014 Kasane", "Botswana", "Kasane", botswanaPhone),
        Stockist("Molamax Botswana \u2014 Francistown", "Botswana", "Francistown", botswanaPhone),
        Stockist("Molamax Botswana \u2014 Gaborone", "Botswana", "Gaborone", botswanaPhone)
    )

    fun whatsappUrl(message: String): String {
        val encoded = java.net.URLEncoder.encode(message, "UTF-8").replace("+", "%20")
        return "https://wa.me/$whatsappNumber?text=$encoded"
    }
}
