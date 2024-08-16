package main;

import character.Character;

/**
 * Handles collision detection within the game, including interactions between
 * characters,
 * objects, and tiles.
 */
public class CollisionChecker {
    GamePanel gp;

    /**
     * Constructs a CollisionChecker object with the GamePanel.
     *
     * @param gp - the main gamepanel of the game
     */
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Checks for collisions between a character object and tile object within the
     * map.
     * Adjusts the character's collision status based on detected collisions.
     *
     * @param character The character entity to check collisions for.
     */
    public void checkTile(Character character) {
        int tileNum1, tileNum2, entityLeftWorldX = character.mapX + character.recArea.x;
        int entityRightWorldX = character.mapX + character.recArea.x + character.recArea.width;
        int entityTopWorldY = character.mapY + character.recArea.y;
        int entityBottomWorldY = character.mapY + character.recArea.y + character.recArea.height;

        this.gp.getClass();
        int entityLeftCol = entityLeftWorldX / 48;
        this.gp.getClass();
        int entityRightCol = entityRightWorldX / 48;
        this.gp.getClass();
        int entityTopRow = entityTopWorldY / 48;
        this.gp.getClass();
        int entityBottomRow = entityBottomWorldY / 48;

        String str;

        switch ((str = character.direction).hashCode()) {
            case 3739:
                if (!str.equals("up"))
                    break;
                this.gp.getClass();
                entityTopRow = (entityTopWorldY - character.speed) / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
                    character.collisionOn = true;
                break;
            case 3089570:
                if (!str.equals("down"))
                    break;
                this.gp.getClass();
                entityBottomRow = (entityBottomWorldY + character.speed) / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
                    character.collisionOn = true;
                break;
            case 3317767:
                if (!str.equals("left"))
                    break;
                this.gp.getClass();
                entityLeftCol = (entityLeftWorldX - character.speed) / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision)
                    character.collisionOn = true;
                break;
            case 108511772:
                if (!str.equals("right"))
                    break;
                this.gp.getClass();
                entityRightCol = (entityRightWorldX + character.speed) / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if ((this.gp.tileM.tile[tileNum1]).collision || (this.gp.tileM.tile[tileNum2]).collision) {
                    character.collisionOn = true;
                }
                break;
        }

    }

    /**
     * Checks for collisions between a character object and object object in the
     * game.
     * This can also detect whether the prisoner character interacts with objects.
     *
     * @param entity   The character to check for collisions with objects.
     * @param prisoner Indicates if the character being checked is the prisoner.
     * @return The index of the object collided with, if any; otherwise, returns a
     *         default high value.
     */
    public int checkObject(Character entity, boolean prisoner) {
        int index = 999;

        for (int i = 0; i < this.gp.obj.length; i++) {

            if (this.gp.obj[i] != null) {

                entity.recArea.x = entity.mapX + entity.recArea.x;
                entity.recArea.y = entity.mapY + entity.recArea.y;

                (this.gp.obj[i]).solidArea.x = (this.gp.obj[i]).mapX + (this.gp.obj[i]).solidArea.x;
                (this.gp.obj[i]).solidArea.y = (this.gp.obj[i]).mapY + (this.gp.obj[i]).solidArea.y;
                String str;
                switch ((str = entity.direction).hashCode()) {
                    case 3739:
                        if (!str.equals("up"))
                            break;
                        entity.recArea.y -= entity.speed;
                        if (entity.recArea.intersects((this.gp.obj[i]).solidArea)) {
                            if ((this.gp.obj[i]).collision) {
                                entity.collisionOn = true;
                            }
                            if (prisoner)
                                index = i;
                        }
                        break;
                    case 3089570:
                        if (!str.equals("down"))
                            break;
                        entity.recArea.y += entity.speed;
                        if (entity.recArea.intersects((this.gp.obj[i]).solidArea)) {
                            if ((this.gp.obj[i]).collision) {
                                entity.collisionOn = true;
                            }
                            if (prisoner)
                                index = i;
                        }
                        break;
                    case 3317767:
                        if (!str.equals("left"))
                            break;
                        entity.recArea.x -= entity.speed;
                        if (entity.recArea.intersects((this.gp.obj[i]).solidArea)) {
                            if ((this.gp.obj[i]).collision) {
                                entity.collisionOn = true;
                            }
                            if (prisoner)
                                index = i;
                        }
                        break;
                    case 108511772:
                        if (!str.equals("right"))
                            break;
                        entity.recArea.x += entity.speed;
                        if (entity.recArea.intersects((this.gp.obj[i]).solidArea)) {
                            if ((this.gp.obj[i]).collision) {
                                entity.collisionOn = true;
                            }
                            if (prisoner) {
                                index = i;
                            }
                        }
                        break;
                }

                entity.recArea.x = entity.recAreaDefaultX;
                entity.recArea.y = entity.recAreaDefaultY;
                (this.gp.obj[i]).solidArea.x = (this.gp.obj[i]).solidAreaDefaultX;
                (this.gp.obj[i]).solidArea.y = (this.gp.obj[i]).solidAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * Checks for collisions between two character entities. used for enemy
     * collision /interactions
     * 
     * @param character The character initiating the collision check.
     * @param target    An array of character entities to check collisions against.
     * @return The index of the target character collided with, if any; otherwise,
     *         returns a default high value.
     */
    public int checkEntity(Character character, Character[] target) {
        int index = 999;

        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {

                character.recArea.x = character.mapX + character.recArea.x;
                character.recArea.y = character.mapY + character.recArea.y;

                (target[i]).recArea.x = (target[i]).mapX + (target[i]).recArea.x;
                (target[i]).recArea.y = (target[i]).mapY + (target[i]).recArea.y;
                String str;
                switch ((str = character.direction).hashCode()) {
                    case 3739:
                        if (!str.equals("up"))
                            break;
                        character.recArea.y -= character.speed;
                        if (character.recArea.intersects((target[i]).recArea)) {
                            character.collisionOn = true;
                            index = i;
                        }
                        break;

                    case 3089570:

                        character.recArea.y += character.speed;
                        if (character.recArea.intersects((target[i]).recArea)) {

                            character.collisionOn = true;
                            index = i;
                        }
                        break;
                    case 3317767:

                        character.recArea.x -= character.speed;
                        if (character.recArea.intersects((target[i]).recArea)) {

                            character.collisionOn = true;
                            index = i;
                        }
                        break;
                    case 108511772:

                        character.recArea.x += character.speed;
                        if (character.recArea.intersects((target[i]).recArea)) {

                            character.collisionOn = true;

                            index = i;

                        }
                        break;
                }

                character.recArea.x = character.recAreaDefaultX;
                character.recArea.y = character.recAreaDefaultY;
                (target[i]).recArea.x = (target[i]).recAreaDefaultX;
                (target[i]).recArea.y = (target[i]).recAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * Specifically checks for collisions between the prisoner character and another
     * character object.
     * Can be used to trigger special events or interactions.
     *
     * @param character The character object to check for collisions with the
     *                  prisoner.
     * @return True if there is a collision with the prisoner; otherwise, false.
     */
    public boolean checkPrisoner(Character character) {
        character.recArea.x = character.mapX + character.recArea.x;
        character.recArea.y = character.mapY + character.recArea.y;

        gp.prisoner.recArea.x = gp.prisoner.mapX + gp.prisoner.recArea.x;
        gp.prisoner.recArea.y = gp.prisoner.mapY + gp.prisoner.recArea.y;
        String str;
        boolean touch = false;
        switch ((str = character.direction).hashCode()) {
            case 3739:
                if (!str.equals("up"))
                    break;
                character.recArea.y -= character.speed;
                if (character.recArea.intersects(gp.prisoner.recArea)) {
                    character.collisionOn = true;
                    touch = true;

                }
                break;

            case 3089570:

                character.recArea.y += character.speed;
                if (character.recArea.intersects(gp.prisoner.recArea)) {

                    character.collisionOn = true;
                    touch = true;
                }
                break;
            case 3317767:

                character.recArea.x -= character.speed;
                if (character.recArea.intersects(gp.prisoner.recArea)) {

                    character.collisionOn = true;
                    touch = true;
                }
                break;
            case 108511772:

                character.recArea.x += character.speed;
                if (character.recArea.intersects(gp.prisoner.recArea)) {

                    character.collisionOn = true;
                    touch = true;

                }
                break;
        }

        character.recArea.x = character.recAreaDefaultX;
        character.recArea.y = character.recAreaDefaultY;
        gp.prisoner.recArea.x = gp.prisoner.recAreaDefaultX;
        gp.prisoner.recArea.y = gp.prisoner.recAreaDefaultY;
        return touch;
    }
}