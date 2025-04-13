ALTER TABLE ninja
ADD COLUMN mission_id INTEGER;

ALTER TABLE ninja
ADD CONSTRAINT fk_ninja_mission
FOREIGN KEY (mission_id)
REFERENCES mission(id)
ON DELETE SET NULL
ON UPDATE CASCADE;
