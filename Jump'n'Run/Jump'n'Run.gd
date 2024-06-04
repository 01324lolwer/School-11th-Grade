extends Node2D



func _on_Void_body_entered(body):
	if body is Player:
		get_tree().reload_current_scene()


func _on_Ziel_body_entered(body):
	if body is Player:
		get_tree().reload_current_scene()


func _on_CollisionShape2D_child_entered_tree(node):
		get_tree().reload_current_scene()
