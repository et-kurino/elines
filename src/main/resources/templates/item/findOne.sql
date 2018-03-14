SELECT
    ITEM_CD,
    ITEM_NM,
    ITEM_VAL,
    IMG_SRC,
    EXPLAN,
    LAST_UPDATE
FROM
    m_item
WHERE
    ITEM_CD = /* itemId */'001'