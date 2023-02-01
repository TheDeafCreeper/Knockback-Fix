package net.prolieum.kbfix

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.lang.Double.max

class Listener: Listener {
    @EventHandler
    fun onEntityKnockback(event: EntityKnockbackByEntityEvent) {
        if (event.entity.velocity.y > 0) return

        // For some reason there's 2 separate knockbacks, one with a strength of .4 and one with some other strength.
        // When testing I noticed the .4 is basically always a Y of 0.4 (or 0 when in the air) and the other one is
        // basically always 0.004 (or 0 when in the air), so I'm using those values as a base.
        if (event.knockbackStrength == 0.4f) event.acceleration.y = max(0.4, event.acceleration.y)
        else event.acceleration.y = max(0.004, event.acceleration.y)
    }
}