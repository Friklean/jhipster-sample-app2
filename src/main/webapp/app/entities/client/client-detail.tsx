import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './client.reducer';

export const ClientDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const clientEntity = useAppSelector(state => state.client.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="clientDetailsHeading">
          <Translate contentKey="aaaApp.client.detail.title">Client</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{clientEntity.id}</dd>
          <dt>
            <span id="nom">
              <Translate contentKey="aaaApp.client.nom">Nom</Translate>
            </span>
          </dt>
          <dd>{clientEntity.nom}</dd>
          <dt>
            <span id="prenom">
              <Translate contentKey="aaaApp.client.prenom">Prenom</Translate>
            </span>
          </dt>
          <dd>{clientEntity.prenom}</dd>
          <dt>
            <span id="adresse">
              <Translate contentKey="aaaApp.client.adresse">Adresse</Translate>
            </span>
          </dt>
          <dd>{clientEntity.adresse}</dd>
          <dt>
            <span id="codePostal">
              <Translate contentKey="aaaApp.client.codePostal">Code Postal</Translate>
            </span>
          </dt>
          <dd>{clientEntity.codePostal}</dd>
          <dt>
            <span id="ville">
              <Translate contentKey="aaaApp.client.ville">Ville</Translate>
            </span>
          </dt>
          <dd>{clientEntity.ville}</dd>
        </dl>
        <Button tag={Link} to="/client" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/client/${clientEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default ClientDetail;
