extends Node2D

##Nächstes Level
func _on_Ziel_body_entered(body):
	if body is Player:
		get_tree().change_scene("res://MainMenu.tscn")

##Neuladen wegen "Tod"
func _on_Void_body_entered(body):
	if body is Player:
		get_tree().reload_current_scene()
