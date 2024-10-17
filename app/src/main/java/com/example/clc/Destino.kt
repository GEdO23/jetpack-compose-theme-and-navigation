package com.example.clc

enum class Rotas {
    FORMULARIO,
    CONFIGURACOES
}

interface Destino {
    val rota: String
}

val destinoFormulario = object : Destino {
    override val rota = "FORMULARIO"
}

val destinoConfiguracoes = object : Destino {
    override val rota = "CONFIGURACOES"
}
