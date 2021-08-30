package na.severinchik.lesson7.data.entity

abstract class BasicUiEntity<T> {
    open fun same(entity: BasicUiEntity<T>): Boolean = false
    open fun contentSame(entity: BasicUiEntity<T>): Boolean = false
}