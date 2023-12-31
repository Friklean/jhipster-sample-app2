import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './livreur.reducer';

export const LivreurDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const livreurEntity = useAppSelector(state => state.livreur.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="livreurDetailsHeading">
          <Translate contentKey="aaaApp.livreur.detail.title">Livreur</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{livreurEntity.id}</dd>
          <dt>
            <span id="commandePreparer">
              <Translate contentKey="aaaApp.livreur.commandePreparer">Commande Preparer</Translate>
            </span>
          </dt>
          <dd>{livreurEntity.commandePreparer}</dd>
          <dt>
            <span id="adresseLivraison">
              <Translate contentKey="aaaApp.livreur.adresseLivraison">Adresse Livraison</Translate>
            </span>
          </dt>
          <dd>{livreurEntity.adresseLivraison}</dd>
          <dt>
            <Translate contentKey="aaaApp.livreur.restaurant">Restaurant</Translate>
          </dt>
          <dd>{livreurEntity.restaurant ? livreurEntity.restaurant.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/livreur" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/livreur/${livreurEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default LivreurDetail;
