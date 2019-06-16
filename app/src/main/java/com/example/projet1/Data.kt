package com.example.projet1

import com.example.projet1.Models.Thematique
import com.example.projet1.Models.Actualite

object Data {
    var useremail : String = "mossabinfo@gmail.com"
    var username : String = "mossab12"
    var userphone : String = "07 65214212"

    var ThematiqueList = ArrayList<Thematique>()
    var ActualiteList = ArrayList<Actualite>()
    val FavoriteActualiteList = ArrayList<Actualite>()

    val theme1 = Thematique("Politique",true)
    val theme2 = Thematique("Sport",true)
    val theme3 = Thematique("Culture",true)

    val actualite1 = Actualite(R.drawable.article1, "Reprise des etudiants des universites","Mossab",theme3,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n")
    val actualite2 = Actualite(R.drawable.article2, "Manifestation des etudiants des univesites","Djeradi",theme3,"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
            "\n")
    val actualite3 = Actualite(R.drawable.article3, "debut du can 2019","Mossab",theme2,"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
            "\n")
    val actualite4 = Actualite(R.drawable.article1, "Reprise des etudiants des universites","Mossab",theme3,"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.\n" +
            "\n")


    init {
        initData()
        ThematiqueList.add(theme1)
        ThematiqueList.add(theme2)
        ThematiqueList.add(theme3)



    }

    fun initData() {

        ActualiteList.removeAll(ActualiteList)
        ActualiteList.add(actualite1)
        ActualiteList.add(actualite2)
        ActualiteList.add(actualite3)
        ActualiteList.add(actualite4)

        var new = ArrayList<Actualite>()

        for (actualite in ActualiteList) {
            if (actualite.theme.allowed) {
                new.add(actualite)
            }
        }

        ActualiteList = new

    }



}