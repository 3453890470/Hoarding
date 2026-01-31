repositories {
    mavenCentral()
    // JEI
    maven {
        name = "Jared's Maven"
        url = uri("https://maven.blamejared.com/")
    }
    // JEI mirror, AE2, Mekanism
    maven {
        name = "ModMaven"
        url = uri("https://modmaven.dev")
    }
    // shedaniel - REI, architectury, cloth-config
    maven {
        url = uri("https://maven.shedaniel.me/")
        content {
            includeGroupAndSubgroups("me.shedaniel")
            includeGroup("dev.architectury")
        }
    }
    // terraformers - EMI
    maven {
        url = uri("https://maven.terraformersmc.com/releases/")
        content {
            includeGroup("dev.emi")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "GeckoLib"
                url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
            }
        }
        filter {
            includeGroup("software.bernie.geckolib")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Curios"
                url = uri("https://maven.theillusivec4.top/")
            }
        }
        filter {
            includeGroup("top.theillusivec4.curios")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                url = uri("https://api.modrinth.com/maven")
            }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "CurseForge"
                url = uri("https://cursemaven.com")
            }
        }
        filter {
            includeGroup("curse.maven")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "FTB Mods"
                url = uri("https://maven.ftb.dev/releases")
            }
        }
        filter {
            includeGroup("dev.ftb.mods")
        }
    }

    mavenLocal()
}