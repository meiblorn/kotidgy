package com.meiblorn.kotidgy.domain.markup.template.node.rule

import com.meiblorn.kotidgy.domain.markup.template.node.Node

class AnyOf(val alternatives: MutableList<Node>) : Node()