import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IRestaurant } from 'app/shared/model/restaurant.model';
import { getEntities as getRestaurants } from 'app/entities/restaurant/restaurant.reducer';
import { ILivreur } from 'app/shared/model/livreur.model';
import { getEntity, updateEntity, createEntity, reset } from './livreur.reducer';

export const LivreurUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const restaurants = useAppSelector(state => state.restaurant.entities);
  const livreurEntity = useAppSelector(state => state.livreur.entity);
  const loading = useAppSelector(state => state.livreur.loading);
  const updating = useAppSelector(state => state.livreur.updating);
  const updateSuccess = useAppSelector(state => state.livreur.updateSuccess);

  const handleClose = () => {
    navigate('/livreur');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getRestaurants({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  // eslint-disable-next-line complexity
  const saveEntity = values => {
    if (values.id !== undefined && typeof values.id !== 'number') {
      values.id = Number(values.id);
    }

    const entity = {
      ...livreurEntity,
      ...values,
      restaurant: restaurants.find(it => it.id.toString() === values.restaurant.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...livreurEntity,
          restaurant: livreurEntity?.restaurant?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="aaaApp.livreur.home.createOrEditLabel" data-cy="LivreurCreateUpdateHeading">
            <Translate contentKey="aaaApp.livreur.home.createOrEditLabel">Create or edit a Livreur</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="livreur-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('aaaApp.livreur.commandePreparer')}
                id="livreur-commandePreparer"
                name="commandePreparer"
                data-cy="commandePreparer"
                type="text"
              />
              <ValidatedField
                label={translate('aaaApp.livreur.adresseLivraison')}
                id="livreur-adresseLivraison"
                name="adresseLivraison"
                data-cy="adresseLivraison"
                type="text"
              />
              <ValidatedField
                id="livreur-restaurant"
                name="restaurant"
                data-cy="restaurant"
                label={translate('aaaApp.livreur.restaurant')}
                type="select"
              >
                <option value="" key="0" />
                {restaurants
                  ? restaurants.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/livreur" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default LivreurUpdate;
