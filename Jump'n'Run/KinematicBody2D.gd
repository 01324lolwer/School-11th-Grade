##Klassen Name
class_name Player

##Der punkt andem das Skript hängt
extends KinematicBody2D

##Konstanten festlegen
const gravity = 10
const speed = 100
const jump_force = -240

##Geschwindigkeit
var velocity = Vector2.ZERO

##Physik des Spielers
func _physics_process(delta):
	if Input.is_action_pressed("left"):
		velocity.x = (-speed)
		$AnimatedSprite.flip_h = false
		$AnimatedSprite.play("walk")
	elif Input.is_action_pressed("right"):
		velocity.x = speed
		$AnimatedSprite.flip_h = true
		$AnimatedSprite.play("walk")
	else:
		velocity.x = 0
		$AnimatedSprite.play("idle")
	if Input.is_action_just_pressed("jump") and is_on_floor():
		velocity.y = jump_force

	velocity.y += gravity
	velocity = move_and_slide(velocity, Vector2.UP)
